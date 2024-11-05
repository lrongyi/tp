package seedu.address.ui;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import seedu.address.commons.core.LogsCenter;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {

    public static final String USERGUIDE_URL = "https://ay2425s1-cs2103t-f11-4.github.io/tp/UserGuide.html";
    public static final String HELP_MESSAGE = "Refer to the user guide: " + USERGUIDE_URL;
    public static final String COMMANDS_INFO = """
            Common Commands:

            1. Adding a contact:
               add n/NAME p/PHONE e/EMAIL a/ADDRESS [t/TAG]...
               Example: add n/John Doe p/98765432 e/johnd@example.com a/311, Clementi Ave 2, #02-25 t/friends

            2. Listing all contacts:
               list

            3. Editing a contact:
               edit INDEX [n/NAME] [p/PHONE] [e/EMAIL] [a/ADDRESS] [t/TAG]...
               Example: edit 1 p/91234567 e/johndoe@example.com

            4. Finding contacts:
               find KEYWORD [MORE_KEYWORDS]
               Example: find alice bob charlie

            5. Deleting a contact:
               delete INDEX
               Example: delete 1

            6. Clearing all entries:
               clear

            7. Help:
               help

            8. Exit:
               exit
            """;
    private static final String FXML = "HelpWindow.fxml";
    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);

    @FXML
    private Button copyButton;

    @FXML
    private Button openBrowserButton;

    @FXML
    private Label helpMessage;

    @FXML
    private TextArea commandsArea;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        helpMessage.setText(HELP_MESSAGE);
        commandsArea.setText(COMMANDS_INFO);
        commandsArea.setEditable(false);
        commandsArea.setWrapText(true);
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     *     <ul>
     *         <li>
     *             if this method is called on a thread other than the JavaFX Application Thread.
     *         </li>
     *         <li>
     *             if this method is called during animation or layout processing.
     *         </li>
     *         <li>
     *             if this method is called on the primary stage.
     *         </li>
     *         <li>
     *             if {@code dialogStage} is already showing.
     *         </li>
     *     </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Opens the user guide URL in the default browser.
     */
    @FXML
    private void openInBrowser() {
        try {
            Desktop.getDesktop().browse(new URI(USERGUIDE_URL));
        } catch (IOException | URISyntaxException e) {
            logger.warning("Error opening URL in browser: " + e.getMessage());
        }
    }

    /**
     * Opens the user guide in the system's default web browser.
     */
    @FXML
    private void openUserGuide() {
        try {
            Desktop.getDesktop().browse(new URI(USERGUIDE_URL));
        } catch (Exception e) {
            logger.warning("Failed to open the user guide in the browser: " + e.getMessage());
        }
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }
}
