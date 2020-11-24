// Custom Exceptions

class InvalidDueDateException extends IllegalArgumentException { // TODO use for set and creating
    public InvalidDueDateException(String msg) {
        super(msg);
    }
}

class InvalidTitleException extends IllegalArgumentException { // TODO use for set and creating
    public InvalidTitleException(String msg) {
        super(msg);
    }
}

class InvalidIndexException extends IllegalArgumentException {
    public InvalidIndexException(String msg) {
        super(msg);
    }
}

class ItemAllBlankException extends IllegalArgumentException {
    public ItemAllBlankException(String msg) {
        super(msg);
    }
}
