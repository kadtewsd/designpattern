package reportvisitor

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class VisitorTest {

    val picePart1 = PiecePart("9999", "myPart", 3)
    val picePart2 = PiecePart("8888", "Hell", 666)
    val assm = Assembly("7777", "MyAssembly")

    @Test
    fun testVisitor() {

        var p1 = false
        var p2 = false
        var a = false
        val foo = object : PartVisitor {
            override fun visit(pp: PiecePart) {
                if (picePart1 == pp) {
                    p1 = true
                }
                if (picePart2 == pp) {
                    p2 = true
                }
            }

            override fun visit(argAssm: Assembly) {
                if (argAssm == assm) {
                    a = true
                }
            }

        }
        with(assm) {
            add(picePart1)
            add(picePart2)
            accept(foo)
        }

        assertTrue(p1)
        assertTrue(p2)
        assertTrue(a)
    }

   @Test
   fun testExplodedCost() {
       val cellPhone = this.cellPhone()
       val v = ExplodedCostVisitor()
       cellPhone.accept(v)
       val answer = (140 + 32 + 322) * 16
       assertEquals(v.cost, answer)
   }

   private fun cellPhone() : Assembly {
        val cellPhone = Assembly("CP-7734", "Cell Phone")
        val display = PiecePart("DS-22", "LCD Display", 140)
        val speaker = PiecePart("SP-34", "Speaker", 32)
        val microphone = PiecePart("MC-23", "Microphone", 322)

        for (x in  0..15) {
            cellPhone.add(display)
            cellPhone.add(speaker)
            cellPhone.add(microphone)
        }
        return cellPhone
    }
}