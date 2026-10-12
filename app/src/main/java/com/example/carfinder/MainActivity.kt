package com.example.carfinder

import android.R.attr.start
import android.graphics.Color.rgb
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.carfinder.ui.theme.CarFinderTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CarFinderTheme {
                MainScreen()
            }
        }
    }
}

@Preview
@Composable
fun MainScreen() {
    // Drawer (fechado por definição)
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    // Animações
    val scope = rememberCoroutineScope()

    //ModalNavigationDrawer
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            //Conteudo da aba lateral
            ModalDrawerSheet {
                Text(
                    text = "Menu Lateral",
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleLarge
                )
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text("Ínicio")},
                    selected = false,
                    onClick = { /*Ação*/ }
                )
                NavigationDrawerItem(
                    label = { Text("Configurações")},
                    selected = false,
                    onClick = { /*Ação*/ }
                )
                NavigationDrawerItem(
                    label = { Text("Sobre")},
                    selected = false,
                    onClick = { /*Ação*/ }
                )
            }
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(rgb(27, 30, 44)))
        ) {
            // Barra Superior / Header
            Box(
                modifier = Modifier
                    .height(120.dp)
                    .fillMaxWidth()
                    .background(Color(rgb(7, 15, 43)))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(40.dp)
                        .background(Color.White)
                )

                Box(
                    modifier = Modifier
                        .padding(top = 65.dp, start = 16.dp, end = 16.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ){
                        IconButton(
                            onClick = {
                                // Abre a Aba lateral
                                scope.launch {
                                    drawerState.open()
                                }

                            }
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_menu_24),
                                contentDescription = "Menu",
                                tint = Color.White,
                                modifier = Modifier.size(32.dp)
                            )
                        }

                        Box() {
                            Image(
                                painter = painterResource(id = R.drawable.carfinder),
                                contentDescription = "Logo",
                                modifier = Modifier
                                    .size(150.dp)
                            )
                        }
                    }
                }
            }
        }
    }

}