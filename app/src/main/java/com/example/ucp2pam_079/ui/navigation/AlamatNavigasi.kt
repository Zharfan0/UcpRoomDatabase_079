package com.example.ucp2pam_079.ui.navigation

interface AlamatNavigasi{
    val route: String
}

object DestinasiHome : AlamatNavigasi{
    override val route = "home"
}

object DestinasiInsertSup : AlamatNavigasi{
    override val route: String = "insert_sup"
}

object DestinasiListSup: AlamatNavigasi{
    override val route: String = "list_sup"
}

object DestinasiInsertBrg : AlamatNavigasi{
    override val route: String = "insert_brg"
}

object DestinasiListBrg: AlamatNavigasi{
    override val route: String = "list_brg"
}

object DestinasiDetailBrg : AlamatNavigasi {
    override val route = "detail"
    const val IDBRG = "idBarang"
    val routesWithArg: String get() = "$route/{$IDBRG}"
    fun getIdBarangFromArg(arg: String?): Int? {
        return arg?.toIntOrNull()
    }
}

object DestinasiUpdateBrg : AlamatNavigasi {
    override val route = "update"
    const val IDBRG = "idBarang"
    val routesWithArg = "$route/{$IDBRG}"
}