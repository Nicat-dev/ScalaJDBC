import java.sql.{DriverManager, ResultSet}

class DataBaseConnector extends App {
  println("Postgres connector")

  classOf[org.postgresql.Driver]
  val con_st = "jdbc:postgresql://localhost:5432/DB_NAME?user=DB_USER"
  val conn = DriverManager.getConnection(con_st)
  try {
    val stm = conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY)

    val rs = stm.executeQuery("SELECT * from Users")

    while(rs.next) {
      println(rs.getString("quote"))
    }
  } finally {
    conn.close()
  }
}
