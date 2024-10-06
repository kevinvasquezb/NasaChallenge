// Simulating real-time updates
let totalAreaLost = 0;

// Function to simulate area loss updates
function updateAreaLost() {
    // Simulate an increase in area lost (in hectares)
    totalAreaLost += Math.floor(Math.random() * 10) + 1; // Random increment between 1 and 10
    document.getElementById('area-amount').textContent = totalAreaLost;

    // Call this function again after 5 seconds to simulate real-time updates
    setTimeout(updateAreaLost, 5000);
}

// Start the simulation
updateAreaLost();
