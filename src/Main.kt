/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener, KeyListener {

    // Fields to hold the UI elements

    private lateinit var userInput: JTextField

    private lateinit var redTextField: JTextField
    private lateinit var redUpButton: JButton
    private lateinit var redDownButton: JButton

    private lateinit var greenTextField: JTextField
    private lateinit var greenUpButton: JButton
    private lateinit var greenDownButton: JButton

    private lateinit var blueTextField: JTextField
    private lateinit var blueUpButton: JButton
    private lateinit var blueDownButton: JButton

    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI
        textField()

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(600, 350)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    private fun textField(){
        val defaultFont = Font(Font.SANS_SERIF, Font.PLAIN, 30)

        userInput = JTextField()
        userInput.bounds = Rectangle(50, 50, 250, 100)
        userInput.background = Color.white
        userInput.font = defaultFont
        userInput.addActionListener(this)
        userInput.addKeyListener(this)
        add(userInput)
    }
    /**
     * Populate the UI with UI controls
     *
     */
    private fun addControls() {
        val defaultFont = Font(Font.SANS_SERIF, Font.PLAIN, 30)

        //========================
        // EVERYTHING RED
        //========================
        redTextField = JTextField()
        redTextField.bounds = Rectangle(50, 200, 100, 100)
        redTextField.background = Color.RED
        add(redTextField)

        redUpButton = JButton("+")
        redUpButton.bounds = Rectangle(150,200,50,50)
        redUpButton.font = defaultFont
        redUpButton.addActionListener(this)     // Handle any clicks
        add(redUpButton)

        redDownButton = JButton("-")
        redDownButton.bounds = Rectangle(150,250,50,50)
        redDownButton.font = defaultFont
        redDownButton.addActionListener(this)     // Handle any clicks
        add(redDownButton)

        //==========================
        // EVERYTHING GREEN
        //==========================
        greenTextField = JTextField()
        greenTextField.bounds = Rectangle(200, 200, 100, 100)
        greenTextField.background = Color.GREEN
        add(greenTextField)

        greenUpButton = JButton("+")
        greenUpButton.bounds = Rectangle(300,200,50,50)
        greenUpButton.font = defaultFont
        greenUpButton.addActionListener(this)     // Handle any clicks
        add(greenUpButton)

        greenDownButton = JButton("-")
        greenDownButton.bounds = Rectangle(300,250,50,50)
        greenDownButton.font = defaultFont
        greenDownButton.addActionListener(this)     // Handle any clicks
        add(greenDownButton)

        //===============================
        // EVERYTHING BLUE
        //===============================
        blueTextField = JTextField()
        blueTextField.bounds = Rectangle(350, 200, 100, 100)
        blueTextField.font = defaultFont
        blueTextField.background = Color.BLUE
        add(blueTextField)

        blueUpButton = JButton("+")
        blueUpButton.bounds = Rectangle(450,200,50,50)
        blueUpButton.font = defaultFont
        blueUpButton.addActionListener(this)     // Handle any clicks
        add(blueUpButton)

        blueDownButton = JButton("-")
        blueDownButton.bounds = Rectangle(450,250,50,50)
        blueDownButton.font = defaultFont
        blueDownButton.addActionListener(this)     // Handle any clicks
        add(blueDownButton)
    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        var userInput: Int = userInput.text.toInt()
        when (e?.source) {
            redUpButton -> {
                userInput++
            }
        }
    }
    override fun keyTyped(e: KeyEvent?) {
        println("Key TYPED: ${e?.keyChar}")
    }

    override fun keyPressed(e: KeyEvent?) {
        println("Key PRESSED: ${e?.keyCode}")

        if (e?.keyCode in KeyEvent.VK_0..KeyEvent.VK_9) {
            println("Number Key!")
        }
        else {
            e?.consume()
        }
    }
    override fun keyReleased(e: KeyEvent?) {
        println("Key RELEASED: ${e?.keyCode}")
    }

}




