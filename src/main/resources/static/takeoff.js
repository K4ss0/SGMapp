function updateProducts() {
    const jobType = document.getElementById('jobType').value;
    const selectionDiv = document.getElementById('selectionOptions');
    selectionDiv.innerHTML = ''; // Clear previous options

    if (jobType === 'Retro') {
        selectionDiv.innerHTML = `
            <select name="product" required>
                <option value="Windows">Windows</option>
                <option value="Doors">Doors</option>
                <option value="Other">Other</option>
            </select>
        `;
    } else if (jobType === 'NewConstruction') {
        selectionDiv.innerHTML = `
            <select name="product" required>
                <option value="Residential">Residential</option>
                <option value="Commercial">Commercial</option>
            </select>
        `;
    } else if (jobType === 'Commercial') {
        selectionDiv.innerHTML = `
            <select name="product" required>
                <option value="Office">Office</option>
                <option value="Retail">Retail</option>
                <option value="Industrial">Industrial</option>
            </select>
        `;
    }
}

// Add an event listener when the DOM is fully loaded
document.addEventListener('DOMContentLoaded', function() {
    const jobTypeSelect = document.getElementById('jobType');
    if (jobTypeSelect) {
        jobTypeSelect.addEventListener('change', updateProducts);
        // Initialize the selections
        updateProducts();
    }else{
        console.error('Job Type select element not found');
    }
});