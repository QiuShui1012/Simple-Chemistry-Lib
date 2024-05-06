package zh.qiushui.simpchemlib.api.exception;

public class OutOfRangeException extends Exception{
    public OutOfRangeException() {
        super();
    }

    public static String oorErrorMsg(Object object) {
        return ("\"" + object.toString() + "\" is out of range!");
    }
}
