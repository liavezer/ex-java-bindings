package da.semigroup.types;

import com.daml.ledger.javaapi.data.DamlRecord;
import com.daml.ledger.javaapi.data.Record;
import com.daml.ledger.javaapi.data.Value;
import org.checkerframework.checker.nullness.qual.NonNull;

import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Max<a> {
  public static final String _packageId = "8a7806365bbd98d88b4c13832ebfa305f6abaeaf32cfa2b7dd25c4fa489b79fb";

  public final a unpack;

  public Max(a unpack) {
    this.unpack = unpack;
  }

  public static <a> Max<a> fromValue(Value value$, Function<Value, a> fromValuea) throws
      IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = (Record) recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    @NonNull List<DamlRecord.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 1) {
      throw new IllegalArgumentException("Expected 1 arguments, got " + numberOfFields);
    }
    a unpack = fromValuea.apply(fields$.get(0).getValue());
    return new da.semigroup.types.Max<a>(unpack);
  }

  public Record toValue(Function<a, Value> toValuea) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(1);
    fields.add(new Record.Field("unpack", toValuea.apply(this.unpack)));
    return new Record(fields);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Max<?>)) {
      return false;
    }
    Max<?> other = (Max<?>) object;
    return this.unpack.equals(other.unpack);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.unpack);
  }

  @Override
  public String toString() {
    return String.format("da.semigroup.types.Max(%s)", this.unpack);
  }
}
