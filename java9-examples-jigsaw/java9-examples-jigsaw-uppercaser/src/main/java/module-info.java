import com.sparkdigital.java9.examples.jigsaw.api.StringTransformer;
import com.sparkdigital.java9.examples.jigsaw.uppercaser.Uppercaser;

module java9.examples.jigsaw.uppercaser {
    requires java9.examples.jigsaw.api;
    provides StringTransformer with Uppercaser;
}