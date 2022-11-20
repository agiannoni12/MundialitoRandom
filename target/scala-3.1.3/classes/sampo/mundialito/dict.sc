val a = (Array("Tunez", "Japon"),"Tunez")
a._1.filterNot(x => x.equals(a._2))