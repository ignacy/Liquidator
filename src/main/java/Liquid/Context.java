package Liquid;

import java.util.HashMap;

/*
 * Klasa będąca nakładką na HashMap, której zadaniem jest przechowywanie
 * wartości parametrów przekazywanych do szablonu, oraz prezentowanie
 * ich w sposób wygodny dla panelu JTable
 */
public class Context extends HashMap<String, String> {

    // Zwraca tablice w postaci:
    //
    // [
    //  [klucz1, wartoscDlaKlucza1 ],
    //  [klucz2, wartoscDlaKlucza2 ],
    //  ...
    // ]
    // Jest to forma, która może być bezpośrednio użyta przez JTable.
    public String[][] asTableContents() {
        String[][] contents = new String[this.keySet().size()][2];

        int index = 0;

        for (String key : this.keySet()) {
            contents[index][0] = key;
            contents[index][1] = this.get(key);
            index++;
        }

        return contents;
    }
}
