import React from 'react'
import './BusList.css';

const BusList = () => {
  return (
    <div className="container">
  <div className="row">
    <div className="card">

    <div className="row container">
      <div className=" bus-column">
        <div className="bus-card">
          <h3>Bus Name</h3>
          <p>Bus Type</p>
        </div>
      </div>

      <div className="bus-column">
        <div className="bus-card">
          <p>Start Time</p>
          <p>From Location</p>
        </div>
      </div>

      <div className="bus-column">
        <p className="bus-card">Travel Duration</p>
      </div>

      <div className="bus-column">
        <div className="bus-card"><p >End Time</p>
          <p>To Location</p></div>
      </div>

      <div className="bus-column">
        <p className="bus-card">Price</p>
      </div>
    </div>


      <button>View Seats</button>
    </div>
  </div>
</div>
  )
}

export default BusList