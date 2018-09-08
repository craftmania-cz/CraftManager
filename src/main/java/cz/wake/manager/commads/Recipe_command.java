package cz.wake.manager.commads;

import cz.wake.manager.managers.RecipeManager;
import cz.wake.manager.utils.IntegerUtil;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;
import org.bukkit.plugin.Plugin;
import sun.applet.Main;

import java.util.HashMap;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Recipe_command implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        ItemStack itemType = null;
        Plugin pl = cz.wake.manager.Main.getInstance();
        Player p = (Player) commandSender;
        try {
            itemType = cz.wake.manager.Main.getInstance().getItemDb().get(args[0]);
        } catch (Exception e) {

        }
        int recipeNo = 0;

        if(args.length == 0) {
            p.sendMessage("§cPouzij /recipe <item> nebo /recipe <id>");
            return false;
        }

        final List<Recipe> recipesOfType = pl.getServer().getRecipesFor(itemType);

        if (args.length > 1) {
            if (IntegerUtil.isInt(args[1])) {
                recipeNo = Integer.parseInt(args[1]) - 1;

            } else {
                p.sendMessage("§cNezname cislo!");
            }
        }
        if (recipeNo < 0 || recipeNo >= recipesOfType.size() ) {
            if (IntegerUtil.isInt(args[0])) {
                p.sendMessage("§cNeexistuje zadny recept pro toto id!");
                return false;
            } else if (recipesOfType.size() < 1) {
                p.sendMessage("§cNeexistuje zadny recept pro tento item!");
                return false;
            }
        }


        final Recipe selectedRecipe = recipesOfType.get(recipeNo);
        //commandSender.sendMessage(tl("recipe", getMaterialName(itemType), recipeNo + 1, recipesOfType.size()));

        if (selectedRecipe instanceof FurnaceRecipe) {
            furnaceRecipe(commandSender, (FurnaceRecipe) selectedRecipe);
        } else if (selectedRecipe instanceof ShapedRecipe) {
            shapedRecipe(commandSender, (ShapedRecipe) selectedRecipe, true);
        } else if (selectedRecipe instanceof ShapelessRecipe) {
            if (recipesOfType.size() == 1 && itemType.getType() == Material.FIREWORK) {
                ShapelessRecipe shapelessRecipe = new ShapelessRecipe(itemType);
                shapelessRecipe.addIngredient(Material.SULPHUR);
                shapelessRecipe.addIngredient(Material.PAPER);
                shapelessRecipe.addIngredient(Material.FIREWORK_CHARGE);
                shapelessRecipe(commandSender, shapelessRecipe, true);
            } else {
                shapelessRecipe(commandSender, (ShapelessRecipe) selectedRecipe, true);
            }
        }

        if (recipesOfType.size() > 1 && args.length == 1) {
            //commandSender.sendMessage(tl("recipeMore", s, args[0], getMaterialName(itemType)));
            //p.sendMessage("§cPouzij /recipe " + args[0] + " ");
        }
        return false;
    }

    public void furnaceRecipe(final CommandSender sender, final FurnaceRecipe recipe) {
        //sender.sendMessage(tl("recipeFurnace", getMaterialName(recipe.getInput())));
    }

    public void shapedRecipe(final CommandSender sender, final ShapedRecipe recipe, final boolean showWindow) {
        final Map<Character, ItemStack> recipeMap = recipe.getIngredientMap();

        if (showWindow) {
            Player p = (Player) sender;
            p.closeInventory();
            RecipeManager.getRecipePlayer(p).setRecipe(true);
            final InventoryView view = p.openWorkbench(null, true);
            final String[] recipeShape = recipe.getShape();
            final Map<Character, ItemStack> ingredientMap = recipe.getIngredientMap();
            for (int j = 0; j < recipeShape.length; j++) {
                for (int k = 0; k < recipeShape[j].length(); k++) {
                    final ItemStack item = ingredientMap.get(recipeShape[j].toCharArray()[k]);
                    if (item == null) {
                        continue;
                    }
                    if (item.getDurability() == Short.MAX_VALUE) {
                        item.setDurability((short) 0);
                    }
                    view.getTopInventory().setItem(j * 3 + k + 1, item);
                }
            }
        } else {
            final HashMap<Material, String> colorMap = new HashMap<>();
            int i = 1;
            for (Character c : "abcdefghi".toCharArray()) {
                ItemStack item = recipeMap.get(c);
                if (!colorMap.containsKey(item == null ? null : item.getType())) {
                    colorMap.put(item == null ? null : item.getType(), String.valueOf(i++));
                }
            }
            final Material[][] materials = new Material[3][3];
            for (int j = 0; j < recipe.getShape().length; j++) {
                for (int k = 0; k < recipe.getShape()[j].length(); k++) {
                    ItemStack item = recipe.getIngredientMap().get(recipe.getShape()[j].toCharArray()[k]);
                    materials[j][k] = item == null ? null : item.getType();
                }
            }
            /*sender.sendMessage(tl("recipeGrid", colorMap.get(materials[0][0]), colorMap.get(materials[0][1]), colorMap.get(materials[0][2])));
            sender.sendMessage(tl("recipeGrid", colorMap.get(materials[1][0]), colorMap.get(materials[1][1]), colorMap.get(materials[1][2])));
            sender.sendMessage(tl("recipeGrid", colorMap.get(materials[2][0]), colorMap.get(materials[2][1]), colorMap.get(materials[2][2])));
*/
            StringBuilder s = new StringBuilder();
            for (Material items : colorMap.keySet().toArray(new Material[colorMap.size()])) {
                //s.append(tl("recipeGridItem", colorMap.get(items), getMaterialName(items)));
            }
            //sender.sendMessage(tl("recipeWhere", s.toString()));
        }
    }

    public void shapelessRecipe(final CommandSender sender, final ShapelessRecipe recipe, final boolean showWindow) {
        final List<ItemStack> ingredients = recipe.getIngredientList();
        if (showWindow) {
            final Player p = (Player) sender;
            final InventoryView view = p.openWorkbench(null, true);
            RecipeManager.getRecipePlayer(p).setRecipe(true);
            for (int i = 0; i < ingredients.size(); i++) {
                final ItemStack item = ingredients.get(i);
                if (item.getDurability() == Short.MAX_VALUE) {
                    item.setDurability((short) 0);
                }
                view.setItem(i + 1, item);
            }

        } else {
            StringBuilder s = new StringBuilder();
            for (int i = 0; i < ingredients.size(); i++) {
                s.append(getMaterialName(ingredients.get(i)));
                if (i != ingredients.size() - 1) {
                    s.append(",");
                }
                s.append(" ");
            }
            //sender.sendMessage(tl("recipeShapeless", s.toString()));
        }
    }

    public String getMaterialName(final ItemStack stack) {
        if (stack == null) {
            return "Nothing";
        }
        return getMaterialName(stack.getType());
    }

    public String getMaterialName(final Material type) {
        if (type == null) {
            return "Nothing";
        }
        return type.toString().replace("_", " ").toLowerCase(Locale.ENGLISH);
    }

}