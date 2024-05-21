module org.krism.bookingappjavafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.graphics;
    requires javafx.base;
    requires javafx.media;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires MaterialFX;
    requires com.jfoenix;
    requires jakarta.persistence;
    requires org.hibernate.orm.core;
    requires com.almasb.fxgl.all;
    requires java.naming;

    opens org.krism to javafx.fxml, javafx.graphics;
    opens org.krism.adduser to javafx.fxml, org.hibernate.orm.core, java.base;
    opens org.krism.cancelbooking to javafx.fxml, org.hibernate.orm.core, java.base;
    opens org.krism.checkin to javafx.fxml, org.hibernate.orm.core, java.base;
    opens org.krism.checkout to javafx.fxml, org.hibernate.orm.core, java.base;
    opens org.krism.deleteuser to javafx.fxml, org.hibernate.orm.core, java.base;
    opens org.krism.guests to javafx.fxml, org.hibernate.orm.core, java.base;
    opens org.krism.homepage to javafx.fxml, org.hibernate.orm.core, java.base;
    opens org.krism.hotel to javafx.fxml, org.hibernate.orm.core, java.base, javafx.base;
    opens org.krism.login to javafx.fxml, org.hibernate.orm.core, java.base;
    opens org.krism.project to javafx.fxml, org.hibernate.orm.core, java.base;
    opens org.krism.roombooking to javafx.fxml, org.hibernate.orm.core, java.base;
    opens org.krism.rooms to javafx.fxml, org.hibernate.orm.core, java.base;
    opens org.krism.users to javafx.fxml, org.hibernate.orm.core, java.base;
    opens org.krism.viewusers to javafx.fxml, org.hibernate.orm.core, java.base;

    exports org.krism.project;

}
