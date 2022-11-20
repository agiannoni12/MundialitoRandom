package sampo.mundialito
import scala.collection.mutable
import scala.util.Random

trait Acciones {

  def combinatoria(entrada :Array[Equipo], s:Array[Array[Equipo]] ):Array[Array[Equipo]]= {
    if (entrada.nonEmpty) {
      val remanentes = entrada.tail
      val primervalor = entrada.head
      val partidos: Array[Array[Equipo]] = s ++ remanentes.map(e => Array(primervalor, e))

      combinatoria(remanentes, s = partidos)
    } else {
      s.tail
    }
  }
  def armarPartidos(grupo: Grupo): Unit ={
    grupo.partidos = combinatoria(grupo.equipos, Array(Array()))

  }

  def jugarPartidoGruos(equipo1:Equipo, equipo2:Equipo): Unit = {

    var golesE1 = 0
    var golesE2 = 0

    for (x<- 1 to 90){

      Random.nextInt(30) match {
      case x if x == equipo2.idunico => golesE2+=1
      case x if x == equipo1.idunico => golesE1+=1
      case _ => None //println("minuto %d de juego".format(x))
    }
  }
    golesE1 match {
      case x if golesE1 < golesE2 => darPuntos(Array(equipo2))
      case x if golesE1 > golesE2 => darPuntos(Array(equipo1))
      case _ => darPuntos(Array(equipo1,equipo2))
    }
    equipo1.goles += golesE1
    equipo2.goles += golesE2

    println("partido entre %s y %s termino: %d a %d".format(equipo1.nombre,equipo2.nombre,golesE1,golesE2))

  }

  def darPuntos(equipos: Array[Equipo]): Unit={
      equipos.length match {
      case 1 => equipos.head.puntos += 1
      case 2 => equipos.foreach(e=> e.puntos+=1)
    }
  }

  def jugarPartidoEliminacion(
                               equipos:Array[Equipo],
                               golesE1:Int = 0,
                               golesE2:Int = 0,
                               alargue:Boolean = false) : Equipo =  {
    //println("Partido entre ")
    //println(equipos.map(e=>e.nombre).mkString(""," vs ", ""))

    val fin: Int = alargue
    match {
      case x if !alargue =>  90
      case _ => 30
    }
    var golesE1Total = golesE1
    var golesE2Total = golesE2

    for(x <- 1 until fin) {

      Random.nextInt(30) match {
        case x if x == equipos.head.idunico => golesE1Total += 1
        case x if x == equipos.tail.head.idunico => golesE2Total += 1
        case _ => None //println("minuto %d de juego".format(x))
      }

    }

      var ganador :Equipo = golesE1Total match {
        case x if golesE1Total>golesE2Total =>  equipos.head
        case x if golesE1Total<golesE2Total =>  equipos.tail.head
        case _ => jugarPartidoEliminacion(equipos,golesE1Total, golesE2Total, alargue = true)
      }

    println("resultado: %s %d -- %s %d".format(equipos.head.nombre,golesE1Total, equipos.tail.head.nombre,golesE2Total))
    println("ganador: %s".format(ganador.nombre))
    ganador
  }

  def imprimirCruces(cruces: Array[Equipo]) : Unit = {

    cruces.grouped(2).toArray.foreach(e=>println(e.map(_.nombre).array.mkString("", " vs ", "")))
  }




}
