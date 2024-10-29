// API Base URL
const API_BASE_URL = 'http://localhost:8080/api';

// DOM Elements
const tabButtons = document.querySelectorAll('.tab-button');
const tabContents = document.querySelectorAll('.tab-content');
const clientForm = document.getElementById('clientForm');
const animalForm = document.getElementById('animalForm');
const appointmentForm = document.getElementById('appointmentForm');
const clientSelect = document.getElementById('clientSelect');
const animalSelect = document.getElementById('animalSelect');
const toast = document.getElementById('toast');

// Tab Switching
tabButtons.forEach(button => {
    button.addEventListener('click', () => {
        tabButtons.forEach(btn => btn.classList.remove('active'));
        tabContents.forEach(content => content.classList.remove('active'));

        button.classList.add('active');
        document.getElementById(button.dataset.tab).classList.add('active');

        if (button.dataset.tab === 'animals') {
            loadClients();
        } else if (button.dataset.tab === 'appointments') {
            loadAnimals();
        }
    });
});

// Toast Messages
function showToast(message, type) {
    toast.textContent = message;
    toast.className = `toast ${type}`;
    setTimeout(() => {
        toast.className = 'toast';
    }, 3000);
}

// Load Data
async function loadClients() {
    try {
        const response = await fetch(`${API_BASE_URL}/clientes`);
        const clients = await response.json();
        updateClientSelect(clients);
    } catch (error) {
        showToast('Erro ao carregar clientes', 'error');
    }
}

async function loadAnimals() {
    try {
        const response = await fetch(`${API_BASE_URL}/animais`);
        const animals = await response.json();
        updateAnimalSelect(animals);
    } catch (error) {
        showToast('Erro ao carregar animais', 'error');
    }
}

// Update Selects
function updateClientSelect(clients) {
    clientSelect.innerHTML = '<option value="">Selecione o Cliente</option>';
    clients.forEach(client => {
        clientSelect.innerHTML += `<option value="${client.id}">${client.nome}</option>`;
    });
}

function updateAnimalSelect(animals) {
    animalSelect.innerHTML = '<option value="">Selecione o Animal</option>';
    animals.forEach(animal => {
        animalSelect.innerHTML += `<option value="${animal.id}">${animal.nome} (${animal.tipo})</option>`;
    });
}

// Form Submissions
clientForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    const clientName = document.getElementById('clientName').value;

    try {
        const response = await fetch(`${API_BASE_URL}/clientes`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nome: clientName })
        });

        if (response.ok) {
            showToast('Cliente cadastrado com sucesso!', 'success');
            clientForm.reset();
            loadClients();
        }
    } catch (error) {
        showToast('Erro ao cadastrar cliente', 'error');
    }
});

animalForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    const animalData = {
        nome: document.getElementById('animalName').value,
        tipo: document.getElementById('animalType').value,
        cliente: { id: clientSelect.value }
    };

    try {
        const response = await fetch(`${API_BASE_URL}/animais`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(animalData)
        });

        if (response.ok) {
            showToast('Animal cadastrado com sucesso!', 'success');
            animalForm.reset();
            loadAnimals();
        }
    } catch (error) {
        showToast('Erro ao cadastrar animal', 'error');
    }
});

appointmentForm.addEventListener('submit', async (e) => {
    e.preventDefault();
    const appointmentData = {
        animal: { id: animalSelect.value },
        tipoServico: document.getElementById('serviceType').value,
        status: 'AGENDADO',
        dataHora: document.getElementById('appointmentDate').value
    };

    try {
        const response = await fetch(`${API_BASE_URL}/agendamentos`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(appointmentData)
        });

        if (response.ok) {
            showToast('Agendamento realizado com sucesso!', 'success');
            appointmentForm.reset();
        }
    } catch (error) {
        showToast('Erro ao criar agendamento', 'error');
    }
});

// Initial load
loadClients();