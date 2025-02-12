package da.random.minstd;

import com.daml.ledger.javaapi.data.Int64;
import com.daml.ledger.javaapi.data.Value;
import com.daml.ledger.javaapi.data.Variant;
import java.lang.IllegalArgumentException;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

public class Minstd extends da.random.Minstd {
  public static final String _packageId = "ed2beae6b3bc8a8804ef43a7add61c87689c18e7b4a2ed45ec2f866df40d16f0";

  public final Long longValue;

  public Minstd(Long longValue) {
    this.longValue = longValue;
  }

  public Variant toValue() {
    return new Variant("Minstd", new Int64(this.longValue));
  }

  public static Minstd fromValue(Value value$) throws IllegalArgumentException {
    Variant variant$ = value$.asVariant().orElseThrow(() -> new IllegalArgumentException("Expected: Variant. Actual: " + value$.getClass().getName()));
    if (!"Minstd".equals(variant$.getConstructor())) throw new IllegalArgumentException("Invalid constructor. Expected: Minstd. Actual: " + variant$.getConstructor());
    Value variantValue$ = variant$.getValue();
    Long body = variantValue$.asInt64().orElseThrow(() -> new IllegalArgumentException("Expected body to be of type com.daml.ledger.javaapi.data.Int64")).getValue();
    return new Minstd(body);
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (!(object instanceof Minstd)) {
      return false;
    }
    Minstd other = (Minstd) object;
    return this.longValue.equals(other.longValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.longValue);
  }

  @Override
  public String toString() {
    return String.format("Minstd(%s)", this.longValue);
  }
}
