package sampo.mundialito

object Entrypoint extends App with equipos {

    armarpartidos()
    armaroctavos()
    mundial.grupos.toSeq.sortBy(_._1).map(gr=>println(gr._1) -> gr._2.equipos.sortBy(_.puntos).reverse.map(e=>println(e.nombre,"puntos: ",e.puntos,"goles: ",e.goles)))
    mundial.octavos.foreach(armarcruces)
    println("CRUCES DE OCTAVOS")
    mundial.crucesoctavos.foreach(g=> println("%s de octavos".format(g._1)) ->  imprimirCruces(g._2))
    println("CRUCES DE CUARTOS")
    mundial.crucesoctavos.keys.foreach(armarcrucesnoOctavos)
    mundial.crucescuartos.foreach(g=> println("%s de cuartos".format(g._1)) -> imprimirCruces(g._2))
    mundial.semifinales = armarSemifinales()
    println("CRUCES DE SEMIS")
    imprimirCruces(mundial.semifinales)
    finalistasYtercerpuesto
    println("TERCERPUESTO")
    imprimirCruces(mundial.tercerPuesto)
    println("FINALISTAS")
    imprimirCruces(mundial.finalistas)

    val campeon = jugarPartidoEliminacion(mundial.finalistas)

    val tercero = jugarPartidoEliminacion(mundial.tercerPuesto)

    println("CUARTO: %s".format(mundial.tercerPuesto.filterNot(x=> x.equals(tercero)).head.nombre))
    println("TERCERO: %s".format(tercero.nombre))
    println("SEGUNDO: %s".format(mundial.finalistas.filterNot(x=> x.equals(campeon)).head.nombre))
    println("CAMPEON: %s".format(campeon.nombre))

}
//grupoA.partidos.foreach(p=> println(p.map(e2 => "%s".format(e2.nombre)).mkString("", ", ", "")))
//mundial.mostrarPartidos()
//grupoC.partidos.foreach(partido => jugarPartido(partido(0),partido(1)))
//grupoC.equipos.foreach(e=> println(e.nombre,e.puntos,e.goles))
//println("--------- clasificados grupo c ---------")
//grupoC.getClasificados.foreach(e => println(e.nombre, e.puntos, e.goles))

/*
mundial.grupos.foreach(
    gr => mundial.clasificadosxGrupo(gr._2(0))
)
mundial.clasificadosGrupos
  .toSeq.sortBy(_._1)
  .map(e=>e._2.map(i=> println(e._1, i.nombre, i.puntos, i.goles)))

mundial.clasificadosGrupos
  .toSeq.sortBy(_._1)
  .map(e=>e._2.map(i=> println(e._1, i.nombre, i.puntos, i.goles)))
*/