document.addEventListener('DOMContentLoaded', function () {
    // Function to navigate to a specific tab by ID
    function goToTab(tabId) {
        const tabs = document.querySelectorAll('.subtablink');
        const tabContents = document.querySelectorAll('.subtabcontent');

        // Remove 'active' class from all tabs and content sections
        tabs.forEach(tab => tab.classList.remove('active'));
        tabContents.forEach(content => content.classList.remove('active'));

        // Add 'active' class to the selected tab and content section
        document.querySelector(`.subtablink[data-tab="${tabId}"]`).classList.add('active');
        document.getElementById(tabId).classList.add('active');
    }

    // Function to edit a specific window
    function editWindow(index) {
        goToTab('SpecificWindowInfo');  // Navigate to the Specific Window Info tab

        const windowData = windowList[index];  // Retrieve the window data

        populateWindowForm(windowData);  // Populate the form with window data
    }

    // Populate form fields with window data
    function populateWindowForm(data) {
        document.getElementById('windowIndex').value = data.index;
        document.getElementById('quantity').value = data.quantity;
        document.getElementById('size').value = data.size;
        document.getElementById('windowType').value = data.type;
        document.getElementById('windowLocation').value = data.location;
        document.getElementById('grids').checked = data.grids;
    }

    // Example data: Initialize the windowList (could be dynamically loaded from the server)
    const windowList = /*[[${windows}]]*/ [];

    // You can also export functions if needed
    window.goToTab = goToTab;
    window.editWindow = editWindow;
});
