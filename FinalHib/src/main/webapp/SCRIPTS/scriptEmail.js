const url = "AjaxController";
if (document.getElementById("inputEmail") !== null) {
    document.getElementById("inputEmail").addEventListener("input", async (event) => {
        debugger;
        const data = new URLSearchParams();
        data.append("email", event.target.value);
        try {
            const response = await fetch(url, {
                method: "POST",
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                body: data.toString(),
            });
            if (response.ok) {
                const data = await response.json();
                if (data.existe) {
                    document.getElementById("correoExistente").textContent = "El correo ya existe en nuestra base de datos";
                    document.getElementById("correoExistente").style.display = "flex";
                    document.getElementById("btnRegistrar").disabled = true;

                } else {
                    document.getElementById("correoExistente").textContent = "";
                    document.getElementById("correoExistente").style.display = "none";
                    document.getElementById("btnRegistrar").disabled = false;
                }
            }
        } catch (error) {
            console.error("Error de conexion");
        }
    })
}


