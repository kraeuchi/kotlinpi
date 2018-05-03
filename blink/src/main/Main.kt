import wiringPi.*
import kotlinx.cinterop.*

// https://tutorials-raspberrypi.de/wiringpi-installieren-pinbelegung/

val LED = 0  // GPIO_GEN0 = GPIO17

//IDE main file
fun main(args: Array<String>) {
    println("Hello, Native World!")
    for (a in 1..10)
        print("${a} ")

    Greeter("Martin").greet()

    println("Now start blinking forever...")
    Blinker(800).blink()
}



class Blinker(val tempo: Int){
    fun blink() {
        wiringPiSetup()
        pinMode(LED, OUTPUT)

        while(true) {
            digitalWrite(LED, HIGH)
            print("HIGH. ")
            delay(tempo)
            digitalWrite(LED, LOW)
            print("LOW. ")
            delay(tempo)
        }
    }
}

class Greeter(val name: String) {
    fun greet() {
        println("Hello, ${name}");
    }
}
