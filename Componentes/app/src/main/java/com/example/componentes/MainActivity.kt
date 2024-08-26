package com.example.componentes

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowColumn
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.componentes.ui.theme.ComponentesTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.NavigationRail
import androidx.compose.material3.NavigationRailItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTooltipScreen()
        }
    }
}
//contenedores
@Composable
fun LazyColumnExample() {
    LazyColumn {
        items(10) { index ->
            Text("Item #$index")
        }
    }
}

@Composable
fun LazyRowExample() {
    LazyRow {
        items(20) { index ->
            Text("Item #$index")
        }
    }
}

@Composable
fun GridExample() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(3)
    ) {
        items(9) { index ->
            Text(text = "Item #$index")
        }
    }
}

// Corrección del nombre a ConstraintLayout con "L" mayúscula
@Composable
fun ConstraintLayoutExample() {
    Text("ConstraintLayout Example")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Scaffold Example") }
            )
        },
        content = { paddingValues ->
            Text(
                text = "Content",
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
            )
        }
    )
}

@Composable
fun SurfaceExample() {
    Surface(
        modifier = Modifier.padding(8.dp),
        color = Color.LightGray,
        shape = RoundedCornerShape(8.dp)
    ) {
        Text("Surface Example", Modifier.padding(16.dp))
    }
}

@Composable
fun FilterChipExample() {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text("Filter chip")
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
    )
}

@Composable
fun BackdropScaffoldExample() {
    Text("BackdropScaffold Example")

}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowRowExample() {
    FlowRow {
        Text("Elemento 1")
        Text("Elemento 2")
        Text("Elemento 3")
    }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FlowColumnExample() {
    FlowColumn {
        Text("Elemento 1")
        Text("Elemento 2")
        Text("Elemento 3")
    }
}
//controles
@Composable
fun MyAlertDialog(onDismiss: () -> Unit, onConfirm: () -> Unit) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = "Título del Diálogo") },
        text = { Text(text = "Este es el contenido del diálogo de alerta.") },
        confirmButton = {
            Button(onClick = onConfirm) {
                Text("Confirmar")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Cancelar")
            }
        }
    )
}
@Composable
fun MySimpleCard() {
    Card(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Este es un ejemplo de una Card simple.",
            modifier = Modifier.padding(16.dp)
        )
    }
}

@Composable
fun MyCheckbox(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Checkbox(
        checked = checked,
        onCheckedChange = onCheckedChange
    )
}

@Composable
fun MyFloatingActionButton(onClick: () -> Unit) {
    FloatingActionButton(onClick = onClick) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Añadir")
    }
}

@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Default.Favorite,
        contentDescription = "Icono de Favorito",
        tint = Color.Red
    )
}
@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.images), // Reemplaza con tu recurso de imagen
        contentDescription = "Descripción de la imagen",
        modifier = Modifier.size(128.dp)
    )
}
@Composable
fun MyProgressBar(progress: Float) {
    LinearProgressIndicator(progress = progress)
}
@Composable
fun MyRadioButton(selected: Boolean, onClick: () -> Unit) {
    RadioButton(
        selected = selected,
        onClick = onClick
    )
}
@Composable
fun MySlider(value: Float, onValueChange: (Float) -> Unit) {
    Slider(
        value = value,
        onValueChange = onValueChange,
        valueRange = 0f..100f
    )
}

@Composable
fun SliderScreen() {
    // Estado para controlar el valor del slider
    var sliderValue by remember { mutableStateOf(50f) }

    // Llamamos al composable MySlider
    MySlider(
        value = sliderValue,
        onValueChange = { newValue ->
            sliderValue = newValue
        }
    )
}
@Composable
fun MySpacer() {
    Spacer(modifier = Modifier.height(16.dp))
}
@Composable
fun MySwitch(checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Switch(
        checked = checked,
        onCheckedChange = onCheckedChange
    )
}
@Composable
fun SwitchScreen() {
    // Estado para controlar si el switch está activado o desactivado
    var isChecked by remember { mutableStateOf(false) }

    // Llamamos al composable MySwitch
    MySwitch(
        checked = isChecked,
        onCheckedChange = { newValue ->
            isChecked = newValue
        }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    TopAppBar(
        title = { Text("TopAppBar") }
    )
}
//otros controles
@Composable
fun MyDialog(showDialog: Boolean, onDismiss: () -> Unit, onConfirm: () -> Unit) {
    if (showDialog) {
        AlertDialog(
            onDismissRequest = onDismiss,
            title = { Text(text = "Dialogo Simple") },
            text = { Text("Este es el contenido del diálogo.") },
            confirmButton = {
                Button(onClick = onConfirm) { Text("Aceptar") }
            },
            dismissButton = {
                Button(onClick = onDismiss) { Text("Cancelar") }
            }
        )
    }
}
@Composable
fun DialogScreen() {
    // Estado para controlar si el diálogo está visible
    var showDialog by remember { mutableStateOf(false) }

    // Botón para mostrar el diálogo
    Button(onClick = { showDialog = true }) {
        Text(text = "Mostrar Diálogo")
    }

    // Llamamos al composable MyDialog
    MyDialog(
        showDialog = showDialog,
        onDismiss = { showDialog = false },
        onConfirm = {
            // Acción al confirmar
            showDialog = false
        }
    )
}

@Composable
fun MyDivider() {
    Divider(thickness = 1.dp, modifier = Modifier.fillMaxWidth())
}
@Composable
fun DividerScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Texto Arriba del Divider")
        MyDivider() // Llamamos a MyDivider
        Text(text = "Texto Debajo del Divider")
    }
}
@Composable
fun LazyVerticalGrid(){
    LazyVerticalGrid(
        columns = GridCells.Fixed(3)
    ) {
        items(9) { index ->
            Text(text = "Item #$index")
        }
    }
}

@Composable
fun MyNavigationRail(items: List<Pair<String, ImageVector>>, onItemSelected: (Int) -> Unit) {
    val selectedIndex = remember { mutableStateOf(0) }
    NavigationRail {
        items.forEachIndexed { index, item ->
            NavigationRailItem(
                icon = { Icon(item.second, contentDescription = item.first) },
                label = { Text(item.first) },
                selected = selectedIndex.value == index,
                onClick = {
                    selectedIndex.value = index
                    onItemSelected(index)
                }
            )
        }
    }
}
@Composable
fun NavigationRailScreen() {
    val items = listOf(
        "Home" to Icons.Filled.Home,
        "Search" to Icons.Filled.Search,
        "Profile" to Icons.Filled.Person
    )

    var selectedItem by remember { mutableStateOf(0) }

    Row(modifier = Modifier.fillMaxSize()) {
        MyNavigationRail(items = items, onItemSelected = { index ->
            selectedItem = index
        })

        Spacer(modifier = Modifier.width(16.dp))

        // Contenido relacionado con el ítem seleccionado
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Text(text = "Ítem seleccionado: ${items[selectedItem].first}")
        }
    }
}

@Composable
fun MyOutlinedTextField(label: String, onTextChange: (String) -> Unit) {
    val text = remember { mutableStateOf("") }
    OutlinedTextField(
        value = text.value,
        onValueChange = {
            text.value = it
            onTextChange(it)
        },
        label = { Text(label) }
    )
}
@Composable
fun OutlinedTextFieldScreen() {
    // Estado para gestionar el texto ingresado
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Llamamos al composable MyOutlinedTextField
        MyOutlinedTextField(
            label = "Introduce tu texto",
            onTextChange = { newText ->
                text = newText
            }
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar el texto ingresado
        Text(text = "Texto ingresado: $text")
    }
}

@Composable
fun MySnackbar(message: String) {
    Snackbar {
        Text(text = message)
    }
}
@Composable
fun SnackbarScreen() {
    // Definir el SnackbarHostState para controlar el Snackbar
    val snackbarHostState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Botón para mostrar el Snackbar
        Button(onClick = {
            coroutineScope.launch {
                snackbarHostState.showSnackbar("Mensaje del Snackbar")
            }
        }) {
            Text(text = "Mostrar Snackbar")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Host para controlar el estado del Snackbar
        SnackbarHost(hostState = snackbarHostState)
    }
}

@Composable
fun MyTabRow(tabs: List<String>) {
    val scope = rememberCoroutineScope()
    val selectedTabIndex = remember { mutableStateOf(0) }

    TabRow(selectedTabIndex = selectedTabIndex.value) {
        tabs.forEachIndexed { index, title ->
            Tab(
                text = { Text(title) },
                selected = selectedTabIndex.value == index,
                onClick = {
                    scope.launch { selectedTabIndex.value = index }
                }
            )
        }
    }
}
@Composable
fun TabRowScreen() {
    val tabs = listOf("Tab 1", "Tab 2", "Tab 3")  // Definir las pestañas

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        MyTabRow(tabs = tabs)

        Spacer(modifier = Modifier.height(16.dp))

        // Contenido relacionado con la pestaña seleccionada
        val selectedTabIndex = remember { mutableStateOf(0) }
        when (selectedTabIndex.value) {
            0 -> Text("Contenido de la Tab 1")
            1 -> Text("Contenido de la Tab 2")
            2 -> Text("Contenido de la Tab 3")
        }
    }
}
@Composable
fun MyTooltip(visible: Boolean, text: String, onDismissRequest: () -> Unit) {
    if (visible) {
        // Usamos Popup para mostrar el tooltip
        Popup(alignment = Alignment.TopCenter, onDismissRequest = onDismissRequest) {
            Box(
                modifier = Modifier
                    .background(Color.Black)
                    .padding(8.dp)
            ) {
                Text(text = text, color = Color.White, fontWeight = FontWeight.Bold)
            }
        }
    }
}
@Composable
fun MyTooltipScreen() {
    // Estado para mostrar o esconder el tooltip
    var showTooltip by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Botón para activar el tooltip
        Button(onClick = { showTooltip = !showTooltip }) {
            Text("Presiona para ver Tooltip")
        }

        // Mostrar el Tooltip
        MyTooltip(
            visible = showTooltip,
            text = "Este es un tooltip!",
            onDismissRequest = { showTooltip = false }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MySpacer()
}