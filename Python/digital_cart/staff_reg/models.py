# This is an auto-generated Django model module.
# You'll have to do the following manually to clean this up:
#   * Rearrange models' order
#   * Make sure each model has one field with primary_key=True
#   * Make sure each ForeignKey and OneToOneField has `on_delete` set to the desired behavior
#   * Remove `managed = False` lines if you wish to allow Django to create, modify, and delete the table
# Feel free to rename the models, but don't rename db_table values or field names.
from django.db import models


class Staff(models.Model):
    sid = models.AutoField(primary_key=True)
    name = models.CharField(max_length=50)
    gender = models.CharField(max_length=20)
    address = models.CharField(max_length=50)
    phone = models.CharField(max_length=30)
    mail = models.CharField(max_length=50)
    password = models.CharField(max_length=20)

    class Meta:
        managed = False
        db_table = 'staff'
