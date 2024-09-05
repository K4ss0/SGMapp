document.addEventListener('DOMContentLoaded', function () {
    const tabs = document.querySelectorAll('.subtablink');
    const tabContents = document.querySelectorAll('.subtabcontent');

    // Function to handle tab switching
    function openTab(event, tabId) {
        tabs.forEach(tab => tab.classList.remove('active'));
        tabContents.forEach(content => content.classList.remove('active'));

        document.getElementById(subtabId).classList.add('active');
        event.currentTarget.classList.add('active');
    }

    tabs.forEach(tab => {
        tab.addEventListener('click', function (event) {
            openTab(event, this.getAttribute('data-tab'));
        });
    });

    document.querySelector('.subtablink').classList.add('active');
    document.querySelector('.subtabcontent').classList.add('active');

    // Handle dynamic brand/series/color selections
    const brandSelect = document.getElementById('window-brands');
    const seriesSelect = document.getElementById('series-types');
    const colorSelect = document.getElementById('color-options');

    const seriesOptions = {
        brand1: ['Series 1A', 'Series 1B', 'Series 1C'],
        brand2: ['Series 2A', 'Series 2B'],
        brand3: ['Series 3A', 'Series 3B', 'Series 3C', 'Series 3D']
    };

    const colorOptions = {
        'Series 1A': ['White', 'Beige'],
        'Series 1B': ['White', 'Gray'],
        'Series 2A': ['Green', 'Blue'],
        'Series 3A': ['Red', 'Yellow'],
        // Add more options as needed
    };

    brandSelect.addEventListener('change', function () {
        const selectedBrand = this.value;

        // Update series options based on selected brand
        seriesSelect.innerHTML = '<option value="">--Select a series/type--</option>';
        if (seriesOptions[selectedBrand]) {
            seriesOptions[selectedBrand].forEach(series => {
                const option = document.createElement('option');
                option.value = series;
                option.textContent = series;
                seriesSelect.appendChild(option);
            });
        }

        // Clear color options when brand changes
        colorSelect.innerHTML = '<option value="">--Select a color--</option>';
    });

    seriesSelect.addEventListener('change', function () {
        const selectedSeries = this.value;

        // Update color options based on selected series
        colorSelect.innerHTML = '<option value="">--Select a color--</option>';
        if (colorOptions[selectedSeries]) {
            colorOptions[selectedSeries].forEach(color => {
                const option = document.createElement('option');
                option.value = color;
                option.textContent = color;
                colorSelect.appendChild(option);
            });
        }
    });
});
