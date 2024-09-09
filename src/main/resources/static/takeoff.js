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

document.addEventListener('DOMContentLoaded', function () {
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


function searchCustomer() {
    const phone1 = document.getElementById('customerPhone1').value;
    const phone2 = document.getElementById('customerPhone2').value;

    fetch(`/api/customer/search?phoneNumber=${phone1}`)
        .then(respones => {
            if (!response.ok) {
                return fetch('/api/customer/search?phoneNumber=${phone2}');
            }
            return response;
        })
        .then(response => response.json())
        .then(data => {
            if (data) {
                document.getElementById('customerFirstName').value = data.firstName;
                document.getElementById('customerLastName').value = data.lastName;
                document.getElementById('customerEmail').value = data.email;
                document.getElementById('customerAddress').value = data.address;
                document.getElementById('customerCity').value = data.city;
                document.getElementById('customerState').value = data.state;
                document.getElementById('customerZip').value = data.zip;
            } else {
                alert('Customer not found. Please enter new customer information.');
                clearCustomerFields();
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('An error occured while searching for the customer');
            clearCustomerFields();
        });
}

function clearCustomerFields() {
    document.getElementById('customerFirstName').value = '';
    document.getElementById('customerLastName').value = '';
    document.getElementById('customerEmail').value = '';
    document.getElementById('customerAddress').value = '';
    document.getElementById('customerCity').value = '';
    document.getElementById('customerState').value = '';
    document.getElementById('customerZip').value = '';
}


function formatPhoneNumber(input) {
    let value = input.value.replace(/\D/g, '');
    if (value.length > 3 && value.length <= 6) {
        value = value.replace(/^(\d{3)(\d+)/, '$1-$2');
    } else if (value.length > 6) {
        value = value.replace(/^(\d{3})(\d{3})(\d+)/, '$1-$2-$3');
    }
    input.value = value;
}