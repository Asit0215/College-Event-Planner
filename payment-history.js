document.addEventListener("DOMContentLoaded", function () {
  const tbody = document.querySelector("tbody");
  const paymentData = JSON.parse(localStorage.getItem("paymentHistory")) || [];

  if (paymentData.length === 0) {
    const row = document.createElement("tr");
    row.innerHTML = `<td colspan="5" class="px-6 py-4 text-center text-gray-500">No payment history found.</td>`;
    tbody.appendChild(row);
  } else {
    paymentData.forEach(item => {
      const row = document.createElement("tr");
      row.className = "hover:bg-gray-50";
      row.innerHTML = `
        <td class="px-6 py-4 font-medium">${item.event}</td>
        <td class="px-6 py-4">${item.date}</td>
        <td class="px-6 py-4">${item.amount}</td>
        <td class="px-6 py-4 text-green-600 font-semibold">${item.status}</td>
        <td class="px-6 py-4">${item.txnId}</td>
      `;
      tbody.appendChild(row);
    });
  }
});
