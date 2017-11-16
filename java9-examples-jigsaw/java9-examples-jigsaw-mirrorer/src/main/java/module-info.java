import com.sparkdigital.java9.examples.jigsaw.api.StringTransformer;
import com.sparkdigital.java9.examples.jigsaw.mirrorer.Mirrorer;

module java9.examples.jigsaw.mirrorer {
    requires java9.examples.jigsaw.api;
    provides StringTransformer with Mirrorer;
}