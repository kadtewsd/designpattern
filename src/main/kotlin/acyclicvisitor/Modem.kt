package acyclicvisitor

interface Modem<in T> where T: ModemVisitor {
    fun dial(pno: String)
    fun hangup()
    fun send(c:Char)
    fun recv(): Char
    /**
     * こっちの引数は Visitor インターフェースになるので、
     * ① Visitor インターフェースのメソッド追加
     * ②実装しているクラスのメソッド追加
     * となる。このため、Visitor インターフェースの修正がチョコチョコ入る。
     */
    fun accept(v: T)
    /**
     * こっちの引数はメソッド定義がないカラのインターフェースなので、
     * ①新たに必要になったインターフェースの追加
     * ②影響を受けるクラスへの実装
     * をする。
     * インターフェースの変更は決して入らない。
     */
    fun acceptAcyclic(v: AcyclicModemVisitor)
}