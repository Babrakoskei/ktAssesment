fun main(){
    var book=listOf(Book("Born a crime","Trveoh Noah",330),
        Book("Apple of her eye","Shawn Corners",477),
        Book("Can you keep a secret","Sophie kinsella",200),
        Book("The mistress","Danielle Steel",285),
        Book("IT","Stephen King",503))
    print(bookList(book))
    square()
    var cash = CurrentAccount("4556666","Babra",6570.98)
    cash.deposit(600.07)
    cash.withdraw(100.0)
    cash.details()

    var money= SavingsAccount("37799990","Elizabeth",5550.89,300)
    money.deposit(900.0)
    money.withdraw(150.00)
    money.details()



}

data class Book(val title:String,val author:String,val pages:Int)
fun bookList(books:List<Book>):List<Book>{
    var sortedBooks=books.sortedByDescending { book->book.title}
    return sortedBooks
}
fun square(){
    var i=-1
    do{
        for (i in 1..3000)
            if (i<3000){
                break
            }
        println(i*i)
        i--
    }
    while (i*i<3000)
}
open class CurrentAccount(var accountNumber: String,var accountName: String,var balance: Double) {
   open fun deposit(amount: Double) {
        balance += amount
        println(balance)

    }
   open fun withdraw(amount: Double){
         balance-= amount
        println(balance)
    }
   open fun details(){
        println("Account number $accountNumber with balance $balance is operated by $accountName" )
    }
}

class SavingsAccount( accountNumber: String, accountName: String, balance: Double,var withdrawals: Int): CurrentAccount(accountNumber,accountName,balance) {
    override fun deposit(amount: Double) {
        balance += amount
        println(balance)

    }

    override fun withdraw(amount: Double) {
        if (withdrawals < 4) {
            balance -= amount
        }
        println(balance)
        withdrawals++

    }

    override fun details() {
        println("Account number $accountNumber with balance $balance is operated by $accountName")
    }
}