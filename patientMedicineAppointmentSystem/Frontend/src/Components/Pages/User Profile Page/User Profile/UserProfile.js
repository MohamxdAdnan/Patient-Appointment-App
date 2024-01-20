import React from 'react'
import './UserProfile.css'

const UserProfile = () => {
  return (
    <div>
        <div class="sidenav">
    <div class="profile">
        <img  width="100" height="100"/>

        <div class="name">
            Name
        </div>
        <div class="job">
            User
        </div>
    </div>

    <div class="sidenav-url">
        <div class="url">
            <a href="#profile" class="active">Profile</a>
            <hr align="center"/>
        </div>
        <div class="url">
            <a href="#settings">Change Password</a>
            <hr align="center"/>
        </div>
        <div class="url">
            <a href="#settings">Booking History</a>
            <hr align="center"/>
        </div>
    </div>
</div>

<div class="main">
    <h2>User Details</h2>
    <div class="card">
        <div class="card-body">
            <i class="fa fa-pen fa-xs edit"></i>
            <table>
                <tbody>
                <tr>
                    <td>Name</td>
                    <td>:</td>
                    <td>Username</td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>:</td>
                    <td>email@gmail.com</td>
                </tr>

                <tr>
                    <td>Payment Method</td>
                    <td>:</td>
                    <td></td>
                </tr>

                </tbody>
            </table>
        </div>
    </div>
</div>
    </div>
  )
}

export default UserProfile