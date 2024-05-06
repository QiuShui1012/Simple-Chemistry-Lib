package zh.qiushui.simpchemlib.api.map;

import zh.qiushui.simpchemlib.api.information.Element;

import java.util.HashMap;
import java.util.Map;

public class ElementStorageMap {
    public static Map<Integer, Element> elementMap = new HashMap<>();

    /**
     *For your convenience in referencing registered elements and reducing hard coding.
     *
     * @param zNumber As the key and the index for future value retrieval.
     * @param information As the value for check.
     */
    public static void registerElementToMap(int zNumber, Element information) {
        boolean registered = verifyZNumberRegistered(zNumber);
        if (!registered) {
            elementMap.put(zNumber, information);
        }
    }

    /**
     * Returns your {@code Element} information if this z number has already been registered.
     *
     * @param zNumber Used to get {@code Element} information.
     * @return {@code Element} When the key has already been registered.
     */
    public static Element getElementInformation(int zNumber) {
        boolean registered = verifyZNumberRegistered(zNumber);
        if (registered) {
            return elementMap.get(zNumber);
        } else {
            throw new NullPointerException("Cannot get object from a null key!");
        }
    }

    /**
     * Returns {@code true} when this z number has already been registered.
     *
     * @param zNumber Used to check if this key has been registered.
     * @return {@code true} When this key has been registered in this Map.
     */
    public static boolean verifyZNumberRegistered(int zNumber) {
        return elementMap.containsKey(zNumber);
    }
}
