package seedu.addressbook.data.tag;

import seedu.addressbook.data.person.*;

public class Tagging {
    private Person person;
    private Tag tag;
    private static final String SEPERATOR = " ";
    
    private enum Operation {
        ADD("+"), DELETE("-");
        
        private String symbol;
        
        private Operation(String symbol) {
            this.symbol = symbol;
        }
        
        public String getSymbol() {
            return symbol;
        }
    }
    
    private Operation operation;
    
    public Tagging(Person person, Tag tag, Operation operation) {
        this.person = person;
        this.tag = tag;
        this.operation = operation;
    }
    
    @Override
    public String toString() {
        return this.operation.getSymbol() + SEPERATOR + this.person.toString() + SEPERATOR + tag.toString();
    }
}
