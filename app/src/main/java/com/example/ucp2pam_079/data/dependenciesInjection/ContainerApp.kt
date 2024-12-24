package com.example.ucp2pam_079.data.dependenciesInjection

import android.content.Context
import com.example.ucp2pam_079.data.database.TokoDatabase
import com.example.ucp2pam_079.data.repository.LocalRepoBrg
import com.example.ucp2pam_079.data.repository.LocalRepoSup
import com.example.ucp2pam_079.data.repository.RepoBrg
import com.example.ucp2pam_079.data.repository.RepoSup

interface InterfaceContainerApp{
    val repositoryBrg: RepoBrg
    val repositorySup: RepoSup
}

class ContainerApp(private val context: Context): InterfaceContainerApp{
    override val repositoryBrg: RepoBrg by lazy {
        LocalRepoBrg(TokoDatabase.getDatabase(context).barangDao())
    }
    override val repositorySup: RepoSup by lazy{
        LocalRepoSup(TokoDatabase.getDatabase(context).supplierDao())
    }

}