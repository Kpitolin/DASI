package util;

import java.util.ArrayList;
import java.util.List;

/**
 * Cette classe regroupe des mÃ©thodes statiques pour gÃ©nÃ©rer alÃ©atoirement
 * des nombre entiers.
 */
public class Aleatoire {

    /**
     * Renvoie un nombre alÃ©atoire entre 0 (inclus) et le paramÃ¨tre range
     * exclus.
     *
     * @param range Borne maximum (exclue)
     * @return Nombre alÃ©atoire gÃ©nÃ©rÃ©
     */
    public static int random(int range) {

        return (int) Math.round(Math.floor(Math.random() * range));
    }

    /**
     * Renvoie un nombre alÃ©atoire entre min (inclus) et max (inclus).
     *
     * @param min Borne minimum (incluse)
     * @param max Borne maximum (incluse)
     * @return Nombre alÃ©atoire gÃ©nÃ©rÃ©
     */
    public static int random(int min, int max) {

        return min + random(1 + max - min);
    }

    /**
     * Renvoie une sous-liste d'index (sans rÃ©pÃ©tition) d'une taille donnÃ©e.
     *
     * @param listSize Taille de la liste initiale
     * @param itemNumber Nombre d'items Ã  inclure
     * @return Sous-liste alÃ©atoire d'index dans la liste initiale
     */
    public static List<Integer> randomSubList(int listSize, int itemNumber) {

        List<Integer> itemIndices = new ArrayList<Integer>(itemNumber);

        for (int i = 0; i < itemNumber; i++) {

            int index = random(listSize - itemIndices.size());

            for (Integer exception : itemIndices) {
                if (index >= exception) {
                    index++;
                }
            }

            itemIndices.add(index);
        }

        return itemIndices;
    }

    /**
     * Cette mÃ©thode main() permet de tester cette classe avant de l'intÃ©grer
     * dans votre code. Elle utilise chacune des mÃ©thodes (statiques) de la
     * classe pour illustrer leur fonctionnement.
     *
     * @param args non utilisÃ© ici
     */
    public static void main(String[] args) {

        int i = random(100); // 0 <= i < 100
        int j = random(2, 5); // 2 <= j <= 5

        System.err.println("i = " + i);
        System.err.println("j = " + j);

        String[] list = {"A", "B", "C", "D", "E", "F", "G", "H", "I"};
        List<Integer> indexList = randomSubList(list.length, 4);

        System.err.print("Sous-Liste:");

        for (Integer index : indexList) {
            System.err.print(" #" + index + " => " + list[index] + ";");
        }

        System.err.println("");
    }
}
