package da.exception.arithmeticerror;

import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.Text;
import com.daml.ledger.javaapi.data.Value;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArithmeticError {
  public static final String _packageId = "cb0552debf219cc909f51cbb5c3b41e9981d39f8f645b1f35e2ef5be2e0b858a";

  public final String message;

  public ArithmeticError(String message) {
    this.message = message;
  }

  public static ArithmeticError fromValue(Value value$) throws IllegalArgumentException {
    Value recordValue$ = value$;
    DamlRecord record$ = recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    List<DamlRecord.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    String message = fields$.get(0).getValue().asText().orElseThrow(() -> new IllegalArgumentException("Expected message to be of type com.daml.ledger.javaapi.data.Text")).getValue();
    return new ArithmeticError(message);
  }

  public DamlRecord toValue() {
    ArrayList<DamlRecord.Field> fields = new ArrayList<DamlRecord.Field>(1);
    fields.add(new DamlRecord.Field("message", new Text(this.message)));
    return new DamlRecord(fields);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof ArithmeticError)) {
      return false;
    }
    ArithmeticError other = (ArithmeticError) object;
    return this.message.equals(other.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.message);
  }

  @Override
  public String toString() {
    return String.format("da.exception.arithmeticerror.ArithmeticError(%s)", this.message);
  }
}