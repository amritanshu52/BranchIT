package com.binarybhaskar.branchitandroid.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.binarybhaskar.branchitandroid.ui.component.UserProfileCard

@Composable
fun ProfileScreen() {
    val uid = FirebaseAuth.getInstance().currentUser?.uid

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        item { Spacer(Modifier.size(8.dp)) }

        item {
            if (uid != null) {
                UserProfileCard(userId = uid)
            } else {
                Text("Not signed in", style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}

