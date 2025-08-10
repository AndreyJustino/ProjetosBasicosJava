package peteTheBaker;

/*
    Pete likes to bake some cakes. He has some recipes and ingredients. Unfortunately he is
    not good in maths. Can you help him to find out, how many cakes he could bake considering
    his recipes?

    Write a function cakes(), which takes the recipe (object) and the available ingredients
    (also an object) and returns the maximum number of cakes Pete can bake (integer). For simplicity
    there are no units for the amounts (e.g. 1 lb of flour or 200 g of sugar are simply 1 or 200).
    Ingredients that are not present in the objects, can be considered as 0.

*/

import java.util.Map;

class PeteBaker {
    public static int cakes(Map<String, Integer> recipe, Map<String, Integer> available) {

        //Isso retorna true se todas as chaves de recipe estão em available.
        //se não estiver todas as chaves retorna 0
        if ( !available.keySet().containsAll(recipe.keySet()) ) return 0;

        int menor = recipe.entrySet().stream()
                .mapToInt(e -> available.get(e.getKey()) / e.getValue())
                .min()
                .orElse(0);

        return menor;
    }
}

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> recipe = Map.of(
                "flour", 500,
                "sugar", 200,
                "eggs", 1);

        Map<String, Integer> available = Map.of(
                "flour", 1200,
                "sugar", 1200,
                "eggs", 5,
                "milk", 200);

        System.out.println(PeteBaker.cakes(recipe, available));;

    }
}
