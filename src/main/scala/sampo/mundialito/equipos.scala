package sampo.mundialito

trait equipos extends Acciones {
  val mundial = new Mundial
  val qatar = new Equipo("Qatar", 0, 0)
  val ecuador = new Equipo("Ecuador", 0, 0)
  val senegal = new Equipo("Senegal", 0, 0)
  val paisesBajos = new Equipo("PaisesBajos", 0, 0)
  //GrupoB
  val inglaterra = new Equipo("Inglaterra", 0, 0)
  val iran = new Equipo("Iran", 0, 0)
  val estadosUnidos = new Equipo("EstadosUnidos", 0, 0)
  val gales = new Equipo("Gales", 0, 0)
  //GrupoC
  val argentina = new Equipo("Argentina", 0, 0)
  val arabiaSaudita = new Equipo("ArabiaSaudita", 0, 0)
  val mexico = new Equipo("Mexico", 0, 0)
  val polonia = new Equipo("Polonia", 0, 0)
  //GrupoD
  val francia = new Equipo("Francia", 0, 0)
  val australia = new Equipo("Australia", 0, 0)
  val dinamara = new Equipo("Dinamara", 0, 0)
  val tunez = new Equipo("Tunez", 0, 0)
  //GrupoE
  val españa = new Equipo("España", 0, 0)
  val costaRica = new Equipo("CostaRica", 0, 0)
  val alemania = new Equipo("Alemania", 0, 0)
  val japon = new Equipo("Japon", 0, 0)
  //GrupoF
  val belgica = new Equipo("Belgica", 0, 0)
  val canada = new Equipo("Canada", 0, 0)
  val marruecos = new Equipo("Marruecos", 0, 0)
  val croacia = new Equipo("Croacia", 0, 0)
  //GrupoG
  val brasil = new Equipo("Brasil", 0, 0)
  val serbia = new Equipo("Serbia", 0, 0)
  val suiza = new Equipo("Suiza", 0, 0)
  val camerun = new Equipo("Camerun", 0, 0)
  //GrupoH
  val portugal = new Equipo("Portugal", 0, 0)
  val ghana = new Equipo("Ghana", 0, 0)
  val uruguay = new Equipo("Uruguay", 0, 0)
  val coreaDelSur = new Equipo("CoreaDelSur", 0, 0)
  ////////////////////////////////////////////////////////////////////////
  val grupoA = new Grupo("A", Array(), Array())
  val grupoB = new Grupo("B", Array(), Array())
  val grupoC = new Grupo("C", Array(), Array())
  val grupoD = new Grupo("D", Array(), Array())
  val grupoE = new Grupo("E", Array(), Array())
  val grupoF = new Grupo("F", Array(), Array())
  val grupoG = new Grupo("G", Array(), Array())
  val grupoH = new Grupo("H", Array(), Array())
  var grupos: Array[Grupo] = Array(grupoA,grupoB,grupoC,grupoD,grupoE,grupoF,grupoG,grupoH)
  grupos.map(mundial.agregarGrupo)

  grupoA.agregarEquiposAgrupo(Array(qatar,ecuador,senegal,paisesBajos))
  grupoB.agregarEquiposAgrupo(Array(inglaterra,iran,estadosUnidos,gales))
  grupoC.agregarEquiposAgrupo(Array(argentina,arabiaSaudita,mexico,polonia))
  grupoD.agregarEquiposAgrupo(Array(francia,australia,dinamara,tunez))
  grupoE.agregarEquiposAgrupo(Array(españa,costaRica,alemania,japon))
  grupoF.agregarEquiposAgrupo(Array(belgica,canada,marruecos,croacia))
  grupoG.agregarEquiposAgrupo(Array(brasil,serbia,suiza,camerun))
  grupoH.agregarEquiposAgrupo(Array(portugal,ghana,uruguay,coreaDelSur))

  mundial.grupos.foreach(g=>g._2.armarPartidos(g._2))
  def armarpartidos() :Unit = {
    grupos.map(g=> g.partidos.map(e => jugarPartidoGruos(e.head, e.tail.head)))
  }

  def armaroctavos():Unit= {
  mundial.grupos.foreach(g=> mundial.clasificadosGrupos += (g._1 -> g._2.getClasificados))
  }

  def armarcruces(grupos: Array[String]):Unit = {

    val cruceIzq : Array[Equipo]=  Array(mundial.clasificadosGrupos(grupos.head).head, mundial.clasificadosGrupos(grupos.tail.head).reverse.head)
    val cruceDer : Array[Equipo]= Array(mundial.clasificadosGrupos(grupos.tail.head).head, mundial.clasificadosGrupos(grupos.head).reverse.head)

    mundial.crucesoctavos("crucesIzq") = mundial.crucesoctavos("crucesIzq") ++ cruceIzq
    mundial.crucesoctavos("crucesDer") = mundial.crucesoctavos("crucesDer") ++ cruceDer
}
  def armarcrucesnoOctavos(rama:String): Unit  = {

    mundial.crucescuartos(rama) = mundial.crucescuartos(rama) ++ mundial.crucesoctavos(rama).grouped(2).toArray.map(jugarPartidoEliminacion(_))

  }

  def armarSemifinales():Array[Equipo] = {

    val ganadores  =  mundial.crucescuartos.map(cr => cr._2.grouped(2).toArray.map(jugarPartidoEliminacion(_)))
    //mundial.crucescuartos.map(cr => cr._2.grouped(2).toArray.map(e=>println(e.map(_.nombre).array.mkString("", " vs ", "")))
    ganadores.flatten.toArray
  }

  def finalistasYtercerpuesto : Unit = {

    val cruces = mundial.semifinales.grouped(2).toArray
    val finalistas = cruces.map(cruce => jugarPartidoEliminacion(cruce))
    mundial.finalistas = finalistas
    val terceros = cruces.zip(finalistas).flatMap(cr => cr._1.filterNot(e =>e.equals(cr._2)))
    mundial.tercerPuesto = terceros
  }




}
