package az.developia.course.qrup28.enums;

public enum ExceptionCode {
    STUDENT_NOT_FOUND_EXCEPTION(100);
    private int code;

    ExceptionCode(int i) {
        code = i;
    }

    public int getCode() {
        return code;
    }
}
