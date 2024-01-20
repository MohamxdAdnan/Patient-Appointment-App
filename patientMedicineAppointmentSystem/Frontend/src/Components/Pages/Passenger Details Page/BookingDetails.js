import React from 'react'
import './BookingDetails.css'

const BookingDetails = () => {
  return (
    <div>
      <div>
  <div class="passenger-card">
    <h3>Passenger Information</h3>
    <form>
      <div class="form-item">
        <label >Name</label>
        <input type="text" placeholder="Name"/>
      </div>
      <div class="form-item">
        <label >Age</label>
        <input type="text" placeholder="Age"/>
      </div>
      <div class="form-item">
        <label >City Of Residence</label>
        <input type="text" placeholder="City Of Residence"/>
      </div>
      <div class="form-item">
        <label >State Of Residence</label>
        <input type="text" placeholder="State Of Residence"/>
      </div>
    </form>
  </div>

  <div class="passenger-card">
    <h3>Contact Information</h3>
    <form>
      <div class="form-item">
        <label >Email ID</label>
        <input type="email" placeholder="Email ID"/>
      </div>
      <div class="form-item">
        <label >Phone</label>
        <input type="text" placeholder="Mobile Number"/>
      </div>
    </form>
  </div>

 <div>
   <button>Proceed To Pay</button>
 </div>
</div>
    </div>
  )
}

export default BookingDetails