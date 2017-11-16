import com.sparkdigital.java9.examples.jigsaw.api.StringTransformer;

module java9.examples.jigsaw.gui {
    exports com.sparkdigital.java9.examples.jigsaw.gui to javafx.graphics;

    requires javafx.base;
    requires javafx.graphics;
    requires javafx.controls;
    requires java9.examples.jigsaw.api;
    uses StringTransformer;
}
