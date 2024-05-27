// Fonction pour formater la date au format "YYYY-MM-DDTHH:MM:SS.sssZ"
function formatDate(date) {
    const year = date.getFullYear();
    const month = (date.getMonth() + 1).toString().padStart(2, '0');
    const day = date.getDate().toString().padStart(2, '0');
    const hours = date.getHours().toString().padStart(2, '0');
    const minutes = date.getMinutes().toString().padStart(2, '0');
    const seconds = date.getSeconds().toString().padStart(2, '0');
    const milliseconds = date.getMilliseconds().toString().padStart(3, '0');
    const timezoneOffset = date.getTimezoneOffset();
    const timezoneOffsetSign = timezoneOffset > 0 ? '-' : '+';
    const timezoneOffsetHours = Math.abs(Math.floor(timezoneOffset / 60)).toString().padStart(2, '0');
    const timezoneOffsetMinutes = (Math.abs(timezoneOffset) % 60).toString().padStart(2, '0');
    return `${year}-${month}-${day}T${hours}:${minutes}:${seconds}.${milliseconds}${timezoneOffsetSign}${timezoneOffsetHours}:${timezoneOffsetMinutes}`;
}

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
            // Ajouter un écouteur d'événements pour le changement de sélection dans la liste déroulante
            select.addEventListener('change', function() {
                const selectedId = parseInt(this.value);
                const selectedVehicle = data.find(vehicle => vehicle.id === selectedId);
                if (selectedVehicle) {
                    document.getElementById('year').value = selectedVehicle.year;
                    document.getElementById('rental_cost_per_day').value = selectedVehicle.rental_cost_per_day;
                    document.getElementById('available').checked = selectedVehicle.available;
                    document.getElementById('location').value = selectedVehicle.location;
                }
            });

            // Ajouter un écouteur d'événements pour le formulaire de réservation
            document.getElementById('form-r').addEventListener('submit', function(event) {
                event.preventDefault(); // Empêcher le formulaire de se soumettre normalement
                const userEmail = localStorage.getItem('userEmail'); // Récupérer l'email du client
                if (!userEmail) {
                    alert("Merci de vous reconnecter pour réserver.");
                    return;
                }

                const selectedId = parseInt(document.getElementById('car').value); // Récupérer l'ID du véhicule sélectionné
                const selectedVehicle = data.find(vehicle => vehicle.id === selectedId);
                const startDate = formatDate(new Date()); // Utiliser la date actuelle au format souhaité
                const endDate = formatDate(new Date(document.getElementById('date_fin').value)); // Convertir la date de fin au format souhaité
                const status = "En attente";

                const reservationData = {
                    vehicle_id: selectedId, // Utiliser le bon ID du véhicule sélectionné
                    customer_email: userEmail,
                    total_cost: selectedVehicle.rental_cost_per_day, // Supposant que le coût total est le même que le coût de location par jour
                    start_date: startDate,
                    end_date: endDate,
                    status: status
                };

                console.log('JSON envoyé au POST :', reservationData); // Ajouter un console.log pour afficher le JSON envoyé

                fetch('http://localhost:8090/api/v1/rentalRecord', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(reservationData)
                })
                    .then(response => {
                        if (response.ok) {
                            return response.json();
                        } else {
                            throw new Error('Erreur lors de la réservation du véhicule');
                        }
                    })
                    .then(data => {
                        // Affichage de la confirmation
                        const selectedVehicleText = `${selectedVehicle.brand} ${selectedVehicle.model}`;
                        alert(`La réservation pour ${selectedVehicleText} est bien enregistrée avec le statut : ${status}`);
                    })
                    .catch(error => console.error('Erreur lors de la réservation du véhicule :', error));
            });
        })
        .catch(error => console.error('Erreur lors de la récupération des véhicules :', error));
}

// Appeler la fonction pour récupérer les véhicules lors du chargement de la page
document.addEventListener('DOMContentLoaded', fetchVehicles);
