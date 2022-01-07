package az.course.test.enums;

public enum ExceptionCode {
    STUDENT_NOT_FOUND_EXCEPTION(100),
    VALIDATION_EXCEPTION(101);
    private int code;

    ExceptionCode(int i) {
        code = i;
    }

    public int getCode() {
        return code;
    }
}
