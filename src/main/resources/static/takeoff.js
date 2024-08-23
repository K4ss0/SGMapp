function updateProducts() {
    console.log('updateProducts function called');
    const jobType = document.getElementById('jobType');
    const productDiv = document.getElementById('productOptions');

    if (!jobType) {
        console.error('Job Type select element not found');
        return;
    }

    if (!productDiv) {
        console.error('Product Options div not found');
        return;
    }

    const selectedJobType = jobType.value;
    console.log('Selected job type:', selectedJobType);

    productDiv.innerHTML = ''; // Clear previous options

    if (selectedJobType === 'Retro') {
        productDiv.innerHTML = `
            <select name="product" required>
                <option value="">Select a product</option>
                <option value="Windows">Windows</option>
                <option value="Doors">Doors</option>
                <option value="Other">Other</option>
            </select>
        `;
    } else if (selectedJobType === 'NewConstruction') {
        productDiv.innerHTML = `
            <select name="product" required>
                <option value="">Select a product</option>
                <option value="Residential">Residential</option>
                <option value="Commercial">Commercial</option>
            </select>
        `;
    } else if (selectedJobType === 'Commercial') {
        productDiv.innerHTML = `
            <select name="product" required>
                <option value="">Select a product</option>
                <option value="Office">Office</option>
                <option value="Retail">Retail</option>
                <option value="Industrial">Industrial</option>
            </select>
        `;
    }
}

document.addEventListener('DOMContentLoaded', function() {
    console.log('DOMContentLoaded event fired');
    const jobTypeSelect = document.getElementById('jobType');
    if (jobTypeSelect) {
        jobTypeSelect.addEventListener('change', updateProducts);
        // Initialize the products based on the default value
        updateProducts();
    } else {
        console.error('Job Type select element not found');
    }
});