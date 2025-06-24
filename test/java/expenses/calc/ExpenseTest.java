package expenses.calc; 
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions ;

public class ExpenseTest  {

    @Test
    public void testExpenseToString() {
        Expense e = new Expense("Lunch", 12.5);
        assertEquals("Lunch: 12.5 EUR", e.toString());
    }
}