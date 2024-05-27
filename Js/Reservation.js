
    // Fonction pour effectuer la requête HTTP GET
    function fetchVehicles() {
    fetch('http://localhost:8090/api/v1/vehicles', {
        method: 'GET',
    })
        .then(response => response.json())
        .then(data => {
            const select = document.getElementById('car');
            data.forEach(vehicle => {
                const option = document.createElement('option');
                option.value = vehicle.id;
                option.text = `${vehicle.brand} ${vehicle.model}`;
                select.appendChild(option);
            });
        })
        .catch(error => console.error('Erreur lors de la récupération des véhicules :', error));
}

    // Appeler la fonction pour récupérer les véhicules lors du chargement de la page
    document.addEventListener('DOMContentLoaded', fetchVehicles);
