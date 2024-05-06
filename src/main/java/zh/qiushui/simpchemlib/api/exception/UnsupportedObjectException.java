package zh.qiushui.simpchemlib.api.exception;

public class UnsupportedObjectException extends Exception{
    public UnsupportedObjectException() {
        super();
    }

    public static String ufErrorMsg(Object object) {
        return ("\"" + object.toString() + "\" is not a supported format!");
    }
}
