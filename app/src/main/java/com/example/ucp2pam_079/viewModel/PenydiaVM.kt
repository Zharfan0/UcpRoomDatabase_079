package com.example.ucp2pam_079.viewModel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ucp2pam_079.MainApp

object PenydiaVM{
    val Factory = viewModelFactory {
        initializer {
            HomeVM(
            )
        }
        initializer {
            InsertSupViewModel(
                TokoApp().containerApp.repositorySup
            )
        }
        initializer {
            ListSupViewModel(
                TokoApp().containerApp.repositorySup
            )
        }
        initializer {
            InsertBrgViewModel(
                TokoApp().containerApp.repositoryBrg
            )
        }
        initializer {
            ListBrgViewModel(
                TokoApp().containerApp.repositoryBrg
            )
        }
        initializer {
            DetailBrgViewModel(
                createSavedStateHandle(),
                TokoApp().containerApp.repositoryBrg,
            )
        }
        initializer {
            UpdateBrgViewModel(
                createSavedStateHandle(),
                TokoApp().containerApp.repositoryBrg
            )
        }

    }
}


fun CreationExtras.TokoApp(): MainApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]as MainApp)