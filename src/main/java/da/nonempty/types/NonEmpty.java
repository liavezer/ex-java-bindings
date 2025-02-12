package da.nonempty.types;

import com.daml.ledger.javaapi.data.DamlCollectors;
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

public class NonEmpty<a> {
  public static final String _packageId = "e22bce619ae24ca3b8e6519281cb5a33b64b3190cc763248b4c3f9ad5087a92c";

  public final a hd;

  public final List<a> tl;

  public NonEmpty(a hd, List<a> tl) {
    this.hd = hd;
    this.tl = tl;
  }

  public static <a> NonEmpty<a> fromValue(Value value$, Function<Value, a> fromValuea) throws
      IllegalArgumentException {
    Value recordValue$ = value$;
    Record record$ = (Record) recordValue$.asRecord().orElseThrow(() -> new IllegalArgumentException("Contracts must be constructed from Records"));
    @NonNull List<DamlRecord.Field> fields$ = record$.getFields();
    int numberOfFields = fields$.size();
    if (numberOfFields != 2) {
      throw new IllegalArgumentException("Expected 2 arguments, got " + numberOfFields);
    }
    a hd = fromValuea.apply(fields$.get(0).getValue());
    List<a> tl = fields$.get(1).getValue().asList()
            .map(v$0 -> v$0.toList(v$1 ->
                fromValuea.apply(v$1)
            ))
            .orElseThrow(() -> new IllegalArgumentException("Expected tl to be of type com.daml.ledger.javaapi.data.DamlList"))
        ;
    return new da.nonempty.types.NonEmpty<a>(hd, tl);
  }

  public Record toValue(Function<a, Value> toValuea) {
    ArrayList<Record.Field> fields = new ArrayList<Record.Field>(2);
    fields.add(new Record.Field("hd", toValuea.apply(this.hd)));
    fields.add(new Record.Field("tl", this.tl.stream().collect(DamlCollectors.toDamlList(v$0 -> toValuea.apply(v$0)))));
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
    if (!(object instanceof NonEmpty<?>)) {
      return false;
    }
    NonEmpty<?> other = (NonEmpty<?>) object;
    return this.hd.equals(other.hd) && this.tl.equals(other.tl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.hd, this.tl);
  }

  @Override
  public String toString() {
    return String.format("da.nonempty.types.NonEmpty(%s, %s)", this.hd, this.tl);
  }
}
